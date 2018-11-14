class Test {

  protected void setUpBeforeTestClass(){
    // initialize a browser driver, connect to servers
  }

  protected void setUpBeforeTestMethod() {
    // initialize testPage
    // login to the app, if necessary
  }

  protected void tearDownAfterTestMethod() {
    // logout of the app, if necessary
  }

  protected void tearDownAfterTestClass() {
    // close connections, close browser as needed
  }
}
