package behavioral.state.ui;

import behavioral.state.states.ReadyState;
import behavioral.state.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> playlist = new ArrayList<>();
    private State state;
    private boolean playing;
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public State getState() {
        return state;
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public boolean isPlaying() {
        return playing;
    }
}
