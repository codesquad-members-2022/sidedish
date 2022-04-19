import { css } from 'styled-components';

export function flex(justify = 'start', align = 'stretch') {
  return `
    display: flex;
    justify-content: ${justify};
    align-items: ${align};
  `;
}

export function applyFlex(props) {
  return (
    props.flex &&
    css`
      ${flex(props.justify, props.align)}
    `
  );
}
