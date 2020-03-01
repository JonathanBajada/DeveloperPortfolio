require 'test/unit'
require_relative 'calculator'

class Calculator_Test < Test::Unit::TestCase
  def setup
    @calculator = Calculator.new
  end

  def test_sum_positive
    result = @calculator.sum(1,1)
    assert_equal(2, result)
  end

  def test_sum_negative
    result = @calculator.sum(-1,-1)
    assert_equal(-2, result)
  end

  def test_sum_zero
    result = @calculator.sum(0,0)
    assert_equal(0, result)
  end
end
