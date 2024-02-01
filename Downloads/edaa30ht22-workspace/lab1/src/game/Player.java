package game;

public abstract class Player {
private String userId;

Player(String userId) {
	this.userId = userId;
}

public String getUserId() {
	return userId;

}

abstract int takePins(Board b);

}
