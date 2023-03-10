package br.geekcode.ticketdiscountcalculator.models.client;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class ClientProfileHandler {
    private ClientProfileHandler nextHandler;

    public static ClientProfileHandler create() {
        return new ClientProfileHandler() {
            public ClientProfile handle(Client client, ClientDto clientDto) {
                if (getNextHandler() != null) return getNextHandler().handle(client, clientDto);
                return ClientProfile.NONE;
            }
        };
    }

    public final ClientProfileHandler use(Class<? extends ClientProfileHandler> handlerClass) {
        try {
            this.nextHandler = handlerClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return nextHandler;
    }

    public abstract ClientProfile handle(Client client, ClientDto clientDto);

    public final ClientProfileHandler getNextHandler() {
        return nextHandler;
    }
}
