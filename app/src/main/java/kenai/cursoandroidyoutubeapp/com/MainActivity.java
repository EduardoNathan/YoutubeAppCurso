package kenai.cursoandroidyoutubeapp.com;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyAa_KuB7o0Kf-cy0JtDIHl5dfKuyAZP-bA";
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
                Toast.makeText(MainActivity.this,
                        "Video Carregando",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoaded(String s) {
                Toast.makeText(MainActivity.this,
                        "Video Carregado",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdStarted() {
                Toast.makeText(MainActivity.this,
                        "Propaganda iniciou",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(MainActivity.this,
                        "Video Comecou",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoEnded() {
                Toast.makeText(MainActivity.this,
                        "Video Acabou",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {
                Toast.makeText(MainActivity.this,
                        "Erro no Video",
                        Toast.LENGTH_SHORT).show();
            }
        };

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {
        Log.i("estado_player", "estado" + foiRestaurado);
        //youTubePlayer.cueVideo("dyfLXRQCWlg");

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if (!foiRestaurado){
            youTubePlayer.cueVideo("dyfLXRQCWlg");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Erro ao inciar o Player!", Toast.LENGTH_SHORT).show();
    }
}