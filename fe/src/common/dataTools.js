const dataTools = {
  addIdToMenuCategoryData: (menuCategoryDatas) =>
    menuCategoryDatas.map(({ menuCategoryName, sideDishes }, idx) => {
      return {
        category: { name: menuCategoryName, id: idx },
        sideDishes,
      };
    }),
};

export default dataTools;
