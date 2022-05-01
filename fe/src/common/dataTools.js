const dataTools = {
  addIdToMenuCategoryData: (menuCategoryDatas) =>
    menuCategoryDatas.map(({ menuCategoryName, sideDishes }, idx) => {
      return {
        category: { name: menuCategoryName, id: idx },
        sideDishes,
      };
    }),

  handleStatus: ({ handler, data }) => {
    const { handleAlert, setAlertMessage } = handler;

    handleAlert();
    setAlertMessage(data.message);
  },
};

export default dataTools;
