/// <reference types="cypress" />
describe("메인화면테스트", () => {
  beforeEach(() => {
    cy.exec("yarn run start");
    cy.visit("/");
    cy.waitForReact();
  });
  it("접속 테스트", () => {
    cy.get('[data-cy="headerMenu"]').trigger("mouseover");
  });
});
