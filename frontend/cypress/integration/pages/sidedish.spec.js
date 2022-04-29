/// <reference types="cypress" />
function getDataset(name) {
  return cy.get(`[data-cy=${name}`);
}

describe("메인화면테스트", () => {
  beforeEach(() => {
    cy.exec("yarn start");
    cy.visit("/");
  });
  it("초기화면 테스트", () => {
    getDataset("headerMenu").should("be.visible");
    getDataset("carouselWrapper").should("be.visible");
    getDataset("special").should("be.visible");
  });
  it("헤더 마우스오버 이벤트 테스트", () => {
    getDataset("headerMenu")
      .trigger("mouseover")
      .then(() => {
        getDataset("subMenu").should("be.visible");
      });
  });
});
