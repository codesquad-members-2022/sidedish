import styled from "styled-components";

function Button({ text, isBtnVisible, onClick }) {
    return (
        <Center isVisible={isBtnVisible}>
            <Btn onClick={onClick}>{text}</Btn>
        </Center>
    );
}

const Center = styled.div`
    display: ${(props) => (props.isVisible ? "flex" : "none")};
    justify-content: center;
    margin-bottom: 56px;
`;

const Btn = styled.button`
    padding: 16px 24px;
    border: 1px solid #ebebeb;
    background-color: white;
`;

export default Button;
