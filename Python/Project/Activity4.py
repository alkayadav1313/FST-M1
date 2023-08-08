from selenium.webdriver.chrome import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)


def openURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
   
    driver.get('https://alchemy.hguy.co/lms')


def verifySecondMostPopularCourseTitle():
    expectedTitle = 'Email Marketing Strategies'
    actualTitle = driver.find_element(By.XPATH,
                                      "//h3[@class='entry-title' and text()='Email Marketing Strategies']").text
    print('The most popular Course Title is:', actualTitle)
    assert expectedTitle == actualTitle
    print('Assertion completed successfully!')


def browserClose():
    driver.quit()

# Open the URL
openURL()

# Verify the second most popular course
verifySecondMostPopularCourseTitle()

# Close the browser
browserClose()