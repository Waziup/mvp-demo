package com.apps.waziup.di;


import dagger.Module;
import dagger.Provides;

/**
 * Define CommentsActivity-specific dependencies here.
 */
@Module
public class CommentsActivityModule {
    @Provides
    CommentsViewModelFactory provideCommentsViewModelFactory(GetCommentsUseCase getCommentsUseCase,
                                                             AddCommentUseCase addCommentUseCase) {
        return new CommentsViewModelFactory(getCommentsUseCase, addCommentUseCase);
    }

    @Provides
    SyncCommentLifecycleObserver provideSyncCommentLifecycleObserver(UpdateCommentUseCase updateCommentUseCase,
                                                                     DeleteCommentUseCase deleteCommentUseCase) {
        return new SyncCommentLifecycleObserver(updateCommentUseCase, deleteCommentUseCase);
    }

    @Provides
    AddCommentUseCase provideAddCommentUseCase(LocalCommentRepository localCommentRepository, SyncCommentUseCase syncCommentUseCase) {
        return new AddCommentUseCase(localCommentRepository, syncCommentUseCase);
    }

    @Provides
    GetCommentsUseCase provideGetCommentsUseCase(LocalCommentRepository localCommentRepository) {
        return new GetCommentsUseCase(localCommentRepository);
    }

    @Provides
    UpdateCommentUseCase provideUpdateCommentUseCase(LocalCommentRepository localCommentRepository) {
        return new UpdateCommentUseCase(localCommentRepository);
    }

    @Provides
    DeleteCommentUseCase provideDeleteCommentUseCase(LocalCommentRepository localCommentRepository) {
        return new DeleteCommentUseCase(localCommentRepository);
    }

    @Provides
    SyncCommentUseCase provideSyncCommentUseCase(RemoteCommentRepository remoteCommentRepository) {
        return new SyncCommentUseCase(remoteCommentRepository);
    }
}
