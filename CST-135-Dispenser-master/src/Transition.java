import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;


public class Transition {

    public void setTransition(ImageView image, ImageView basket){

        Line line = new Line(image.getX(), image.getY(), image.getX(), basket.getY());
        PathTransition pt = new PathTransition();

        pt.setPath(line);
        pt.setNode(image);
        pt.setDuration(Duration.seconds(2));
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
    };
}
