package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBooksCard() {
        List<WebElement> books = driver.findElements(By.xpath(""));
        if (!books.isEmpty()) {
            // Выбор случайной книги
            Random random = new Random();
            int randomIndex = random.nextInt(books.size());
            WebElement randomBook = books.get(randomIndex);
            randomBook.click();
        } else {
            System.out.println("No books found on the page.");
        }

//    public void clickOnBooksCard(String book) {
//        driver.findElement(By.xpath("//*[contains(@mr-2, '" + book + "')]/ancestor::tr//*[@class='col-12 mt-4 col-md-6']")).click();
//    }
    }

    public List<WebElement> getBooks() {
        return null;
    }

    public boolean isBookInCollection(String title, String author) {
        return false;
    }
}