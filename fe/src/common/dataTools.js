const dataTools = {
  addIdToMenuCategoryData: (menuCategoryDatas) =>
    menuCategoryDatas.map(({ menuCategoryName, sideDishes }, idx) => {
      return {
        category: { name: menuCategoryName, id: idx },
        sideDishes,
      };
    }),

  handleStatus: ({ handler, status, data }) => {
    const { handleAlert, setAlertMessage } = handler;

    switch (status) {
      case 200:
      case 400:
      case 401:
      default:
        handleAlert();
        setAlertMessage(data.message);
        break;
    }
  },
};

export default dataTools;
