import styled from "styled-components";

function Button({ text }) {
    return (
        <Center>
            <Btn>{text}</Btn>
        </Center>
    );
}

const Center = styled.div`
    display: flex;
    justify-content: center;
    margin-bottom: 56px;
`;

const Btn = styled.button`
    padding: 16px 24px;
    border: 1px solid #ebebeb;
    background-color: white;
`;

export default Button;
