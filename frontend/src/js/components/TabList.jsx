import {goodsData} from '../data/goods.js';

function TabList({tabState, setTabState}) {
  const tabStateHandler = ({target}) => {
    setTabState(prevState => {
      return {...prevState, category: target.title};
    });
  };

  return goodsData.map(element => (
    <li
      className={tabState === element.tab.title ? 'selected' : ''}
      key={element.id}
      title={element.tab.title}
      onClick={tabStateHandler}
    >
      {element.tab.title}
    </li>
  ));
}

export {TabList};
