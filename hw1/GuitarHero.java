
public class GuitarHero {
    private static final double CONCERT_A = 440.0;

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        synthesizer.GuitarString[] strings = new synthesizer.GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double temp = CONCERT_A * Math.pow(2, ((double) (i - 24)) / 12);
            strings[i] = new synthesizer.GuitarString(temp);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    strings[keyboard.indexOf(key)].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = strings[0].sample();
            for (int i = 1; i < 37; i++) {
                sample = sample + strings[i].sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < 37; i++) {
                strings[i].tic();
            }
        }
    }
}
