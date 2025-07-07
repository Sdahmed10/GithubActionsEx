package tests;

import com.microsoft.playwright.*;

public class SimpleTest {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            String title = page.title();

            if (title.contains("Playwright")) {
                System.out.println("Test Passed: Title contains 'Playwright'");
            } else {
                System.out.println("Test Failed: Title is " + title);
                System.exit(1); // Faille le test
            }

            browser.close();
        }catch (Exception e) {
            System.out.println("Exception during test execution:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
