import styled from "styled-components";

function Login() {
    return (
        <Center>
            <a href="http://3.35.134.169/api/auth/github">
                <LoginButton>Login with GitHub</LoginButton>
            </a>
        </Center>
    );
}

const Center = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #f1f3f5;
`;

const LoginButton = styled.button`
    padding: 12px 80px;
    background-color: #212529;
    color: white;
    font-size: 1.6rem;
    border-radius: 10px;
`;

export default Login;
