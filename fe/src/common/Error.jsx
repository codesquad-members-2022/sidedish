import styled from 'styled-components';

const Error = styled.div`
  margin: 0 auto;
  padding: 100px 0;
  text-align: center;
  ${({ theme }) => theme.fontStyles.logo};
`;

const ErrorComponent = () => {
  return <Error>데이터 불러오기 실패...🥲</Error>;
};

export default ErrorComponent;
