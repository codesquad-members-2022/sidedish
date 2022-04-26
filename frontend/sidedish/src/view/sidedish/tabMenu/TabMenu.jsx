import { TabBar, Tab } from "./TabMenu.style";

function TabMenu({ currTab, tabMenu, onChangeTab }) {
    const tabMenuTemplate = tabMenu.map((tab, idx) => {
        return (
            <Tab
                isCurrTab={idx === currTab}
                key={tab.id}
                onClick={() => onChangeTab(idx)}
            >
                {tab.name}
            </Tab>
        );
    });

    return <TabBar>{tabMenuTemplate}</TabBar>;
}

export default TabMenu;
