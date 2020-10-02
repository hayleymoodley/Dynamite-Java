package training.dynamite;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.*;


public class MyBot implements Bot {

    public MyBot() {
        System.out.println("Started new match");
    }

    @Override
    public Move makeMove(Gamestate gamestate) {
        if (gamestate.getRounds().size() == 0) {
            return Move.D;
        } else {
            Round lastRound = gamestate.getRounds().get(gamestate.getRounds().size() - 1);
            return getMoveThatBeats(lastRound.getP2());
        }
    }

    private Move getMoveThatBeats(Move theirLastMove) {
        switch (theirLastMove) {
            case R:
                return Move.P;
            case P:
                return Move.S;
            case S:
                return Move.R;
            case D:
                return Move.W;
            case W:
                return getRandomMove();
            default:
                throw new RuntimeException("INVALID");
        }
    }

    public Move getRandomMove() {
        int randomNumberBetween0And3 = (int) Math.floor(Math.random() * 3.0D);
        Move[] possibleMoves = new Move[]{Move.R, Move.P, Move.S};
        return possibleMoves[randomNumberBetween0And3];
    }
}





















