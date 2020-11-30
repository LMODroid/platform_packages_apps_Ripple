package info.guardianproject.ripple;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class AnimationHelpers {

    public static void translateY(final View view, float fromY, float toY, long duration) {
        if (duration == 0)
            view.setTranslationY(toY);
        else
            view.animate().translationY(toY).setDuration(duration).start();
    }

    public static void scale(final View view, float fromScale, float toScale, long duration, final Runnable whenDone) {
        if (duration == 0) {
            view.setScaleX(toScale);
            view.setScaleY(toScale);
            if (whenDone != null)
                whenDone.run();
        } else {
            ViewPropertyAnimator animation = view.animate().scaleX(toScale).scaleY(toScale).setDuration(duration);
            if (whenDone != null) {
                animation.setListener(new AnimatorListener() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        whenDone.run();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        whenDone.run();
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                });
            }
            animation.start();
        }
    }
}
