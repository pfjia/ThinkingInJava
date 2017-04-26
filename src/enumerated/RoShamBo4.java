package enumerated;

/**
 * Created by pfjia on 2017/4/26 0026.
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSORS, competitor);
        }
    }, SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(PAPER, competitor);
        }
    }, PAPER {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(ROCK, competitor);
        }
    };


    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return (opponent == this) ? Outcome.DRAW : ((opponent == loser) ? Outcome.WIN : Outcome.LOSE);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
