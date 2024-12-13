import edu.princeton.cs.algs4.StdAudio;

public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        synthesizer.GuitarString[] stringArray = new synthesizer.GuitarString[37];
        for (int i = 0; i < keyboard.length(); i++) {
            stringArray[i] = new synthesizer.GuitarString(440 * Math.pow(2, (i - 24.0) / 12.0));
        }

        int idx = 0;

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                idx = keyboard.indexOf(key);
                stringArray[idx].pluck();
            }

            /* compute the superposition of samples */
            double sample = stringArray[idx].sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < keyboard.length(); i++) {
                stringArray[i].tic();
            }
        }
    }
}
