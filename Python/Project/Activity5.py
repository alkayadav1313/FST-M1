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


def navigateToAccountPageAndVerifyPageTitle():

    driver.find_element(By.LINK_TEXT, "My Account").click()
    actualTitle = driver.title
    expectedTitle = 'My Account – Alchemy LMS'
    assert actualTitle == expectedTitle
    print('Assertion completed successfully!')
    print('You redirected to My Account Page')


def closeBrowser():
    driver.quit()



# open the browser and navigate URL
openBrowserAndNavigateURL()

# navigate to account page and verify page's title
navigateToAccountPageAndVerifyPageTitle()

#Close the browser
closeBrowser()
