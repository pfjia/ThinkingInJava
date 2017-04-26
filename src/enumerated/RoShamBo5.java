package enumerated;

import java.util.EnumMap;

/**
 * Created by pfjia on 2017/4/26 0026.
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);

    static {
        for (RoShamBo5 roShamBo5 : RoShamBo5.values()) {
            table.put(roShamBo5, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
            initRow(PAPER, Outcome.DRAW, Outcome.LOSE, Outcome.WIN);
            initRow(SCISSORS, Outcome.WIN, Outcome.DRAW, Outcome.LOSE);
            initRow(ROCK, Outcome.LOSE, Outcome.WIN, Outcome.DRAW);
        }
    }

    static void initRow(RoShamBo5 it, Outcome vPaper, Outcome vScissors, Outcome vRock) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPaper);
        row.put(RoShamBo5.SCISSORS, vScissors);
        row.put(RoShamBo5.ROCK, vRock);
    }


    @Override
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);

    }
}
