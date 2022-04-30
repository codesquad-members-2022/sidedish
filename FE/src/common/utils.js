export const methodFormat = (callback) => {
  const method = async (...args) => {
    try {
      const data = await callback(...args);
      return {
        ok: true,
        data,
      };
    } catch (error) {
      return {
        ok: false,
        message: error.message,
      };
    }
  };
  return method;
};

export const moneyToWon = (money) => {
  const moneyArr = [];
  let newMoney = money;
  while (newMoney >= 1000) {
    moneyArr.push(newMoney % 1000);
    newMoney = Math.floor(newMoney / 1000);
  }

  const str = moneyArr.reduce((acc, next) => {
    const nextArr = Array.from(next);
    const zeros = new Array(3 - nextArr.length).fill(0);
    return `${acc},${[...zeros, ...nextArr].join('')}`;
  }, '');

  return `${newMoney + str}원`;
};
