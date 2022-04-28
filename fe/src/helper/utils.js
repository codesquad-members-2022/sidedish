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

const RANDOM_MIN_DEFAULT = 0;
const RANDOM_MAX_DEFAULT = 100;

function getRandomNumber({ min, max }) {
  min = min || RANDOM_MIN_DEFAULT;
  max = max || RANDOM_MAX_DEFAULT;
  return Math.floor(Math.random() * (max - min)) + min;
}

export function getRandomNumberAsCount({ min, max, count }) {
  min = min || RANDOM_MIN_DEFAULT;
  max = max || RANDOM_MAX_DEFAULT;
  if (!count) {
    throw Error;
  }
  if (max - min < count) {
    throw Error;
  }
  const answerSet = new Set();
  while (answerSet.size < count) {
    answerSet.add(getRandomNumber({ min, max }));
  }
  return [...answerSet];
}

export function getUrlWithIdPage({ url, id, page }) {
  page = page || 0;
  return `${url}/${id}?page=${page}`;
}
