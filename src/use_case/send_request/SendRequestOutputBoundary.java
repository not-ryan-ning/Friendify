package use_case.send_request;

public interface SendRequestOutputBoundary {
    /**
     * Trigger the successful view of the send request use case
     * @param user
     */
    void prepareSuccessView(SendRequestOutputData user);

    /** Trigger the fail view of the send request use case
     *
     * @param error The error from the send request use case
     */
    void prepareFailView(String error);
}
