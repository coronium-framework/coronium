package org.coronium.util.constant;

public class User {
    public enum Credentials{
        DEMO_DEVICE("automation@democompany.com", "Password3",
                "titanadmin@demo.silversky.com", "Password1",
                "qatestaccount@demodomain.com", "1Q@2$ecure3*Us");

        private final String userName;
        private final String password;

        // QA Environment
        Credentials(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        //For Staging Environment
        Credentials(String userNameQA, String passwordQA,
                    String userNameStg, String passwordStg) {

            String username = userNameQA;
            String password = passwordQA;

            String environment = System.getProperty("environment");
            if (environment.contains("stage")) {
                username = userNameStg;
                password = passwordStg;
            }
            this.userName = username;
            this.password = password;
        }

        //For Production
        Credentials(String userNameQA, String passwordQA,
                    String userNameStg, String passwordStg,
                    String userNameProd, String passwordProd) {

            String username = userNameQA;
            String password = passwordQA;

            String environment = System.getProperty("environment");
            if (environment.contains("stage")) {
                username = userNameStg;
                password = passwordStg;
            } else if (environment.contains("cloud")) {
                username = userNameProd;
                password = passwordProd;
            }
            this.userName = username;
            this.password = password;
        }

    }
}
