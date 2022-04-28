import styled from "styled-components";

function Button2ShowAllCategory({ text, isBtnVisible, onClick }) {
    return (
        <Center isVisible={isBtnVisible}>
            <Btn onClick={onClick}>{text}</Btn>
        </Center>
    );
}

const Center = styled.div`
    display: ${(props) => (props.isVisible ? "flex" : "none")};
    justify-content: center;
`;

const Btn = styled.button`
    padding: 16px 24px;
    border: 1px solid #ebebeb;
    background-color: white;
    margin-bottom: 56px;
`;

export default Button2ShowAllCategory;
