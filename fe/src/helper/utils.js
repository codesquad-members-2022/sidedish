function getFlexTemplate({ justify, align, direction }) {
  justify = justify || 'start';
  align = align || 'stretch';
  direction = direction || 'row';
  return `
    display: flex;
    justify-content: ${justify};
    align-items: ${align};
    flex-direction: ${direction};
  `;
}

export function applyFlex({ flex, justify, align, direction }) {
  return (
    flex &&
    `${getFlexTemplate({ justify, align, direction })}
    `
  );
}

export async function fetchData(url) {
  try {
    const data = await fetch(url);
    return data.json();
  } catch (error) {
    console.error(error);
    return error;
  }
}
