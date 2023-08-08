from selenium.webdriver.chrome import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)


def openBrowserAndNavigateURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
    driver.get('https://alchemy.hguy.co/lms')


def clickContactUsAndFillInfo():
    driver.find_element(By.LINK_TEXT, "Contact").click();
    driver.find_element(By.ID, "wpforms-8-field_0").send_keys("Kylie Jenner")
    driver.find_element(By.ID, "wpforms-8-field_1").send_keys("kylie34@gmail.com")
    driver.find_element(By.ID, "wpforms-8-field_3").send_keys("More Information about Course")
    driver.find_element(By.ID, "wpforms-8-field_2").send_keys("I want to know types of courses available.")

    driver.find_element(By.ID, "wpforms-submit-8").click()
    message = driver.find_element(By.XPATH,
                                  "//div[contains(@id,'wpforms-confirmation')]/p").get_attribute(
        "innerHTML")
    print("The message displayed is :", message)


def closeBrowser():
    driver.quit()


# Open browser and Navigate to URL
openBrowserAndNavigateURL()

# Fill the required information
clickContactUsAndFillInfo()

# Close the browser
closeBrowser()