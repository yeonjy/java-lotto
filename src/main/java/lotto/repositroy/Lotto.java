package lotto.repositroy;

import lotto.ErrorMessage;
import lotto.LottoRangeNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSixNumbers(numbers);
        checkNotDuplicated(numbers);
        checkInRange(numbers);
    }

    private void checkSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoRangeNumber.NUM_OF_LOTTO_NUMS.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
        }
    }

     private void checkNotDuplicated(List<Integer> numbers) {
         if (numbers.size() != numbers.stream().distinct().count()) {
             throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.getMessage());
         }
     }

    private void checkInRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(n -> n <= LottoRangeNumber.MAX_LOTTO_NUM.getNum()
                && n >= LottoRangeNumber.MIN_LOTTO_NUM.getNum())) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
