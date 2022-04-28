/// <reference types="cypress" />
function getDataset(name) {
  return cy.get(`[data-cy=${name}`);
}

describe("메인화면테스트", () => {
  beforeEach(() => {
    cy.exec("yarn run start");
    cy.visit("/");
    cy.waitForReact();
  });
  cy.it("접속 테스트", () => {
    cy.get('[data-cy="headerMenu"]')
      .trigger("mouseover")
      .then(() => {
        cy.get(`[data-cy="submenu"]`).should("have.length", "3");
        cy;
      });
  });
});
