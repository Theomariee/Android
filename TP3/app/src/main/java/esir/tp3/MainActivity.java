package esir.tp3;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView label;
    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.labelButton);
        button = findViewById(R.id.logoButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleLabelAlpha();
                animateButton();
            }
        });

        label.setAlpha(0f);
        button.setAlpha(0f);
        button.setTranslationX(-200f);
    }

    @Override
    protected void onResume() {
        super.onResume();
        OvershootInterpolator interpolator = new OvershootInterpolator();

        button.animate()
                .setStartDelay(500)
                .setDuration(1000)
                .alpha(1f)
                .rotation(360f)
                .translationX(0f)
                .setInterpolator(interpolator);
    }

    private void toggleLabelAlpha() {
        float newAlpha = (1f) - label.getAlpha();
        label.animate()
                .setDuration(200)
                .alpha(newAlpha)
                .start();
    }

    private void animateButton() {
        button.animate()
                .scaleX(2f)
                .scaleY(2f)
                .alpha(0f)
                .setListener(listener)
                .start();
    }

    Animator.AnimatorListener listener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationEnd(Animator animator) {
            button.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
                    .start();
        }

        @Override
        public void onAnimationStart(Animator animator) {}

        @Override
        public void onAnimationCancel(Animator animator) {}

        @Override
        public void onAnimationRepeat(Animator animator) {}
    };
}
