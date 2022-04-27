import { useState, useEffect } from "react";
import { Container, Header, Title } from "./Sidedish.style";
import { API } from "../../config";
import { ThemeProvider } from "styled-components";
import { getData } from "../../utils";
import SidedishCards from "./SidedishCards";
import TabMenu from "./tabMenu/TabMenu";

const theme = {
    size: "big",
};

function BigSidedish() {
    const [currTab, setTab] = useState(0);
    const [bigSidedishData, setBigSidedishData] = useState(null);
    const changeTab = (index) => {
        setTab(index);
    };

    useEffect(() => {
        try {
            getData(
                API.FESTIVAL + "한-번-주문하면-두-번-반하는-반찬",
                setBigSidedishData
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
        <ThemeProvider theme={theme}>
            <Container>
                <Header>
                    <Title>한 번 주문하면 두 번 반하는 반찬</Title>
                    <TabMenu
                        currTab={currTab}
                        tabMenu={tabMenu}
                        onChangeTab={changeTab}
                    />
                </Header>
                <SidedishCards dishes={bigSidedishData[currTab].dishes} />
            </Container>
        </ThemeProvider>
    );
}

export default BigSidedish;
