package enumerated;

/**
 * Created by pfjia on 2017/4/25 0025.
 */
public interface Competitor<T> {
    Outcome compete(T competitor);
}
