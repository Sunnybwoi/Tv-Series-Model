package tvseriesmodel;

/**
 *
 * @author ST10472846
 */
public class TvSeriesModel {

    public static boolean r = true;

    public static void main(String[] args) {

        //Loop Assisted By: Student Notes [Offline]
        while (r) {
            String op = """
                    LATEST SERIES - 2025
                    ************************
                    Enter (1) To Launch Menu
                    Or Any Other Key To Exit:
                    """;

            System.out.print(op);
            String menu = Series.scn.nextLine();
            //Menu Assisted By: Student Notes [Offline]

            switch (menu) {
                case "1" -> {

                    while (r) {
                        String menu_ = """
                        Please Select One Of The Following Menu Items:
                        1) Capture a new series.
                        2) Search for a series.
                        3) Update series age restriction
                        4) Delete a series.
                        5) Print series report - 2025
                        6) Exit Application.
                        """;

                        System.out.println(menu_);
                        String opt = Series.scn.nextLine();

                        switch (opt) {
                            case "1" -> {
                                Series.captureSeries();//Calls Capture Method
                            }
                            case "2" -> {
                                Series.searchSeries();//Calls Search Method
                            }
                            case "3" -> {
                                Series.updateSeries();//Calls Update Method
                            }
                            case "4" -> {
                                Series.deleteSeries();//Calls Deletion Method
                            }
                            case "5" -> {
                                Series.seriesReport();//Calls Report Method
                            }
                            case "6" -> {
                                Series.exitSeriesApplication();//Calls Exit Method
                            }
                            default ->{
                                System.out.println("Invalid Input, Please Try Again!\n");
                            }
                            
                        }
                    }
                }
                default -> {//When 1 Is Not Pressed
                    System.out.println("Closing Application");
                    break;
                }

            }

        }

    }

}
/*
Student Notes [Offline].
[Accessed 28 August 2025]
*/
