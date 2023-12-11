package racingcar;

import racingcar.application.RunRace;
import racingcar.domain.RaceCommand;

import static racingcar.view.InputView.inputRace;

public class RacingCarApplication {
    public static void main(String[] args) {
        RaceCommand raceCommand = inputRace();
        RunRace.startRace(raceCommand.getCarCount(), raceCommand.getTryCount());
    }
}
