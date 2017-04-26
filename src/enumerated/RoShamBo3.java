package enumerated;

/**
 * Created by pfjia on 2017/4/26 0026.
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return Outcome.DRAW;
                case SCISSORS:
                    return Outcome.LOSE;
                case ROCK:
                    return Outcome.WIN;
            }
        }
    }, SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case ROCK:
                    return Outcome.LOSE;
                case PAPER:
                    return Outcome.WIN;
                case SCISSORS:
                    return Outcome.DRAW;
            }
        }
    }, ROCK {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case SCISSORS:
                    return Outcome.WIN;
                case PAPER:
                    return Outcome.LOSE;
                case ROCK:
                    return Outcome.DRAW;
            }
        }
    };

    @Override
    public abstract Outcome compete(RoShamBo3 competitor);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
