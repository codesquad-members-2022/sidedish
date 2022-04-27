import {TabItem} from "./TabList.styled";

function TabList({title, tabState, setTabState}) {
  const handleTabState = ({target}) => {
    setTabState(prevState => {
      return {...prevState, category: target.title};
    });
  };

  return (
    <TabItem tabState={tabState} title={title} onClick={handleTabState}>
      {title}
    </TabItem>
  );
}

export {TabList};
