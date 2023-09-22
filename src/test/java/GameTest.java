import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void ListGamePlayersTest() {
        Player genna = new Player(1, "Генна", 123);
        Player ignat = new Player(2, "Игнат", 234);
        Game game = new Game();

        game.register(genna);
        game.register(ignat);
        int expected = 2;
        int actual = game.round("Генна", "Игнат");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ListGameLostPlayersTest() {
        Player genna = new Player(1, "Генна", 235);
        Player ignat = new Player(2, "Игнат", 234);
        Game game = new Game();

        game.register(genna);
        game.register(ignat);
        int expected = 1;
        int actual = game.round("Генна", "Игнат");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ListGamePlayersDrawTest() {
        Player genna = new Player(1, "Генна", 123);
        Player ignat = new Player(2, "Игнат", 123);
        Game game = new Game();

        game.register(genna);
        game.register(ignat);
        int expected = 0;
        int actual = game.round("Генна", "Игнат");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ListGameNotRegisterPlayersTest2() {
        Player genna = new Player(1, "Генна", 123);
        Player ignat = new Player(2, "Игнат", 234);
        Game game = new Game();

        game.register(genna);
        game.register(ignat);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Анна", "Игнат"));
    }

    @Test
    public void ListGameNotRegisterPlayersTest1() {
        Player genna = new Player(1, "Генна", 123);
        Player ignat = new Player(2, "Игнат", 234);
        Game game = new Game();

        game.register(genna);
        game.register(ignat);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Генна", "Чуппакабра"));
    }
}
