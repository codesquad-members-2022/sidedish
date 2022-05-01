import { useState, useEffect } from "react";
import { BigContainer, Header, BigDishTitle } from "./Sidedish.style";
import { API } from "../../config";
import { getData } from "../../utils";
import SidedishCards from "./SidedishCards";
import TabMenu from "./tabMenu/TabMenu";

function BigSidedish() {
    const [currTab, setTab] = useState(0);
    const [bigSidedishData, setBigSidedishData] = useState(null);
    const changeTab = (index) => {
        setTab(index);
    };

    useEffect(() => {
        try {
            getData(API.FESTIVAL + "한-번-주문하면-두-번-반하는-반찬").then(
                (data) => setBigSidedishData(data)
            );
        } catch (error) {
            console.error(error);
        }
    }, []);

    if (!bigSidedishData) {
        return;
    }

    const tabMenu = bigSidedishData.map((sidedish) => {
        return {
            id: sidedish.categoryId,
            name: sidedish.categoryName,
        };
    });

    return (
        <BigContainer>
            <Header>
                <BigDishTitle>한 번 주문하면 두 번 반하는 반찬</BigDishTitle>
                <TabMenu
                    currTab={currTab}
                    tabMenu={tabMenu}
                    onChangeTab={changeTab}
                />
            </Header>
            <SidedishCards
                dishes={bigSidedishData[currTab].dishes}
                isBigCards
            />
        </BigContainer>
    );
}

export default BigSidedish;
