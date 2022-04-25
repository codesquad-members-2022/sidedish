import { setupWorker } from "msw";
import handlers from "MockData/handlers";

const worker = setupWorker(...handlers);

export default worker;
