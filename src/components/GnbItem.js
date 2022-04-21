import React from 'react';
import styled from 'styled-components';

const GnbItem = ({ title, contents }) => {
  return (
    <GnbTap>
      <GnbTitle>{title}</GnbTitle>
      <GnbCategory>
        {contents.map((content, idx) => (
          <GnbContent key={idx}>{content}</GnbContent>
        ))}
      </GnbCategory>
    </GnbTap>
  );
};

const GnbTap = styled.div`
  padding: 35px 24px 28px 0;
`;

const GnbTitle = styled.span`
  cursor: pointer;
`;

const GnbCategory = styled.ul`
  display: none;
`;

const GnbContent = styled.li`
  padding-top: 10px;
  cursor: pointer;
  &:hover {
    text-decoration: underline;
  }
`;
export default GnbItem;
