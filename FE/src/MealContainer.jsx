import React from "react";
import styled from "styled-components";

// TODO: style.js로 분리하기
const MealContainerStyled = styled.div``;

const MealCarouselStyled = styled.div`
	display: flex;
`;

// TODO: style.js로 분리하기
const MealCardStyled = styled.li`
	display: flex;
	flex-direction: column;
	img {
		width: 200px;
		height: 200px;
	}
`;

// TODO: loader 컴포넌트 분리하기
function Loader() {
	return <div>Loading...</div>;
}

// TODO: component로 분리하기
function MealCard({ mealInfo }) {
	const { productName, description, event, fixedPrice, image, originalPrice } = mealInfo;
	return (
		<MealCardStyled>
			<img src={image || "default image url"} alt="food" />
			<h4>{productName}</h4>
			<p>{description}</p>
			<div>
				<span>{fixedPrice}</span>
				<span>{originalPrice}</span>
			</div>
			<div>{event}</div>
		</MealCardStyled>
	);
}

// TODO: component로 분리하기
function Carousel({ cards }) {
	return (
		<MealCarouselStyled>
			<button>⬅️</button>
			{cards.map(({ id, ...mealInfo }) => (
				<MealCard key={id} mealInfo={mealInfo} />
			))}
			<button>➡️</button>
		</MealCarouselStyled>
	);
}

function MealContainer({ meals }) {
	const { mealHeader, mealCards } = meals;
	return (
		<MealContainerStyled>
			<h2>{mealHeader}</h2>
			{mealCards.length === 0 ? <Loader /> : <Carousel cards={mealCards} />}
		</MealContainerStyled>
	);
}

export default MealContainer;
