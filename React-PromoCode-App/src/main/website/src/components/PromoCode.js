import React, {Component} from 'react';
import classes from './PromoCode.css';
import axios from 'axios';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {

            //object arrays
            mailArray: [],
            promoArray: [],

            //TextFeilds
            ssnInput: '',
            promoInput: '',
            emailInput: '',

            //Jaglms
            promoCode: '',
            ssn: '',
            first_name: '',
            ssnHolder: '',
            last_name: '',
            address: '',
            address2: '',
            claimed_timestamp: '',
            expired_timestamp: '',
            city: '',
            zipcode: '',
            savings: '',

            //webapi
            email: '',
            state: '',
            ssn4: '',
            ssnMail: '',
            promoWeb: '',
            campaign_name: '',
            validation_date: '',
            application_status: '',
            create_datetime: '',
            update_datetime: ''
        };
        this.handleChangePromo = this.handleChangePromo.bind(this);
        this.handleChangeEmail = this.handleChangeEmail.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    //Changes state value of promoInput
    handleChangePromo(event) {
        this.setState({promoInput: event.target.value});
    }

    //Changes state value of promoInput
    handleChangeEmail(event) {
        this.setState({emailInput: event.target.value});
    }

    //Allows submit to process
    handleSubmit(event) {
        event.preventDefault();
    }


    //This method sends a post request to the server to search promocodes in the database
    postDataPromoCode(event) {
        console.log(this);
        const CustomerPromotions = {
            promoCode: this.state.promoInput,
            ssn: this.state.ssnInput,
        };
        const DirectMail = {
            promoCode: this.state.promoInput,
            ssn4: this.state.ssnInput,
            email: this.state.emailInput

        };
        let DirectMailArray = {};
        let PromoArray = {};
        let TempArray = [];
        axios.all([
            axios.post("http://localhost:8080/customerPromo", CustomerPromotions),
            axios.post("http://localhost:8080/directMail", DirectMail)
        ])
            .then(axios.spread((response, response2) => {
                let i = 0;
                let j = 0;
                let k = 0;

                //Reset Text Fields
                this.setState({promoInput: ""});
                this.setState({emailInput: ""});
                this.setState({mailArray: TempArray});
                this.setState({promoArray: TempArray});

                for (j; j < response2.data.length; j++) {
                    if (response2.data[j].promoCode === DirectMail.promoCode) {
                        DirectMailArray[k] = response2.data[j];
                        k++;
                        let newStateArray2 = this.state.mailArray.slice();
                        newStateArray2.push(response2.data[j]);
                        this.setState({mailArray: newStateArray2});
                    }
                }

                for (i; i < response.data.length; i++) {
                    if (response.data[i].promoCode === CustomerPromotions.promoCode) {
                        PromoArray[j] = response.data[i];
                        j++;
                        let newStateArray = this.state.promoArray.slice();
                        newStateArray.push(response.data[i]);
                        this.setState({promoArray: newStateArray});
                        return;
                    }
                }
            })).catch((error) => {
            if (error.response) {
                alert("PROMOCODE NOT IN DATABASE!");
                this.setState({promoInput: ""});
                this.setState({emailInput: ""});
                this.setState({mailArray: TempArray});
                this.setState({promoArray: TempArray});
            }
        });
    }

    //This method sends a post request to the server to search for an email in the database
    postDataEmail(event) {
        console.log(this);
        const DirectMail = {
            promoCode: this.state.promoInput,
            ssn4: this.state.ssnInput,
            email: this.state.emailInput
        };
        let DirectMailArray = {};
        let TempArray = [];
        axios.post("http://localhost:8080/email", DirectMail)
            .then(response => {
                let i = 0;
                let j = 0;
                let emailCount = 0;

                this.setState({promoInput: ""});
                this.setState({emailInput: ""});
                this.setState({ssnInput: ""});

                this.setState({mailArray: TempArray});
                this.setState({promoArray: TempArray});

                for (i; i < response.data.length; i++) {
                    if (response.data[i].email === DirectMail.email) {
                        DirectMailArray[j] = response.data[i];
                        j++;
                        var newStateArray = this.state.mailArray.slice();
                        newStateArray.push(response.data[i]);
                        emailCount++;
                        this.setState({mailArray: newStateArray});
                    }

                }
                if(emailCount === 0){
                    alert("EMAIL NOT IN DATABASE!");
                }

            });
    }


    render() {
        return (
            <div className={classes.card}>
                <form onSubmit={this.handleSubmit} style={{backgroundColor: '#43b55f', padding: '25px 0'}}>
                    <h2 className={classes.Apptitle}>Promotional Codes</h2>
                    <input type="text"
                           value={this.state.promoInput}
                           onChange={this.handleChangePromo}
                           name="docName" className={classes.textField}
                           placeholder={"Enter Promocode #"}/>
                    <br/>
                    <input type="text"
                           value={this.state.emailInput}
                           onChange={this.handleChangeEmail}
                           name="docName" className={classes.textField}
                           placeholder={"Enter Email"}/>
                    <br/>
                    <br/>
                    <input type="submit" value="Search Promocode"
                           className={classes.submitButton1}
                           onClick={(event) => this.postDataPromoCode(event)}/>
                    <input type="submit" value="Search Email"
                           className={classes.submitButton2}
                           onClick={(event) => this.postDataEmail(event)}/>
                </form>
                <div style={{backgroundColor: '#ffffff'}}>
                    <table className={classes.table}>
                        <caption className={classes.promoTable}><b>Customer Promotions</b></caption>
                        <tr>
                            <th id="name">first_name</th>
                            <th>last_name</th>
                            <th>address</th>
                            <th>address2</th>
                            <th>city</th>
                            <th>zipcode</th>
                            <th>ssn</th>
                            <th>claimed_timestamp</th>
                            <th>expired_timestamp</th>
                        </tr>
                        {this.state.promoArray.map((PromoCode, index) => {
                            return (<tbody>
                            <td>{PromoCode.firstName}</td>
                            <td>{PromoCode.last_name}</td>
                            <td>{PromoCode.address}</td>
                            <td>{PromoCode.address2}</td>
                            <td>{PromoCode.city}</td>
                            <td>{PromoCode.zipcode}</td>
                            <td>{PromoCode.convertedSSN}</td>
                            <td>{PromoCode.claimed_timestamp}</td>
                            <td>{PromoCode.expired_timestamp}</td>
                            </tbody>)

                        })}
                    </table>
                    <br/>
                    <br/>
                    <table className={classes.table}>
                        <caption className={classes.promoTable}><b>Direct Mail Information</b></caption>
                        <tr>
                            <th>email</th>
                            <th>state</th>
                            <th>ssn4</th>
                            <th>promo_code</th>
                            <th>campaign_name</th>
                            <th>validation_date</th>
                            <th>create_datetime</th>
                            <th>update_datetime</th>
                        </tr>
                        {this.state.mailArray.map((DirectMail, index) => {
                            return (<tbody>
                            <td>{DirectMail.email}</td>
                            <td>{DirectMail.state}</td>
                            <td>{DirectMail.ssn4}</td>
                            <td>{DirectMail.promoCode}</td>
                            <td>{DirectMail.campaignName}</td>
                            <td>{DirectMail.validationDate}</td>
                            <td>{DirectMail.createDatetime}</td>
                            <td>{DirectMail.updateDatetime}</td>
                            </tbody>)
                        })}
                    </table>
                </div>
            </div>
        );
    }
}

export default App;

