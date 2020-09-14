for (let i = 1; i <= 10; i++) {
	console.log('outer loop:', i);
	for (let j = 10; j >= 0; j -= 2) {
		console.log(' inner loop', j);
	}
}

const gameBoard = [ [ 4, 32, 8, 4 ], [ 64, 8, 32, 2 ], [ 8, 32, 16, 4 ], [ 2, 8, 4, 2 ] ];

let totalScore = 0;
for (let i = 0; i < gameBoard.length; i++) {
	let row = gameBoard[i];
	console.log(row);
	for (let j = 0; j < row.length; j++) {
		console.log(row[j]);
		totalScore += row[j];
	}
	console.log(totalScore);
}

let j = 0;
while (j <= 5) {
	j++;
}
