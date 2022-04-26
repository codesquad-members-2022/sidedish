import {TabItem} from './TabList.styled';

function TabList({tab, tabState, setTabState}) {
  const handleTabState = ({target}) => {
    setTabState(prevState => {
      return {...prevState, category: target.title};
    });
  };

  return (
    <TabItem tabState={tabState} title={tab.title} onClick={handleTabState}>
      {tab.title}
    </TabItem>
  );
}

export {TabList};
