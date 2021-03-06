package com.vit.domain.usecase.contact;

import com.vit.domain.usecase.contact.model.Contact;
import com.vit.domain.usecase.contact.repository.ContactRepository;
import com.vit.domain.FlowableUseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

@Singleton
public class GetContactListUseCase extends FlowableUseCase<List<Contact>> {

    @Inject
    ContactRepository contactRepository;

    @Inject
    public GetContactListUseCase(@Named("SchedulerType.IO") Scheduler schedulerIO,
                                 @Named("SchedulerType.UI") Scheduler schedulerUI) {
        super(schedulerIO, schedulerUI);
    }


    @Override
    protected Flowable<List<Contact>> buildUseCaseObservable() {
        return contactRepository.getContacts();
    }
}
